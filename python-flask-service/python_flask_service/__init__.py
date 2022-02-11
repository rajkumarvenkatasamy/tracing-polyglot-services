"""
Author: Rajkumar Venkatasamy
"""

from flask import Flask
import py_eureka_client.eureka_client as ec

from python_flask_service.controller.greetings_controller import greetings_blueprint
from python_flask_service.util.zipkin_utils import ZipkinUtils

python_flask_service = Flask(__name__)

# Controllers' Blueprints registration -- starts
python_flask_service.register_blueprint(greetings_blueprint, url_prefix="/python-flask-service/api/v1/")
# Controllers' Blueprints registration -- ends

ec.init(eureka_server="http://service-registry:8761/eureka",
        app_name="python-flask-service",
        instance_port=5000
        )


@python_flask_service.before_request
@ZipkinUtils.zipkin_setup_wrapper
def before_request():
    """
    This function will run before every request.
    :return:
    """
    print("At python_flask_service.before_request()", flush=True)
