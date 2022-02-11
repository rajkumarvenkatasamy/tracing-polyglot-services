"""
Author: Rajkumar Venkatasamy
"""
from functools import wraps

import requests
from flask import request
from py_zipkin import Encoding
from py_zipkin.util import ZipkinAttrs
from py_zipkin.zipkin import zipkin_span


class ZipkinUtils:

    @staticmethod
    def default_handler(encoded_span):
        """
        This method is a transport handler to post the span details to the zipkin url
        :param encoded_span: message that contains span details
        :return:
        """
        body = encoded_span
        print(body, flush=True)

        return requests.post(
            "http://zipkin:9411/api/v2/spans",
            data=body,
            headers={'Content-Type': 'application/json'},
        )

    @staticmethod
    def zipkin_setup_wrapper(func):
        """
        This method is used as a decorator to setup zipkin_span so that the requests can be traced and logged
        :param func: object of the method where the decorator is applied
        :return: wrapper function
        """

        @wraps(func)
        def wrapper(*args, **kwargs):
            with zipkin_span(
                    service_name="python-flask-service",
                    zipkin_attrs=ZipkinAttrs(
                        trace_id=request.headers.get('X-B3-TraceID'),
                        span_id=request.headers.get('X-B3-SpanID'),
                        parent_span_id=request.headers.get('X-B3-ParentSpanID'),
                        flags=1,
                        is_sampled=request.headers.get('X-B3-Sampled'),
                    ),
                    span_name=str(request.method) + " " + str(request.path),
                    transport_handler=ZipkinUtils.default_handler,
                    port=5000,
                    sample_rate=100,
                    encoding=Encoding.V2_JSON
            ):
                func()

        return wrapper
