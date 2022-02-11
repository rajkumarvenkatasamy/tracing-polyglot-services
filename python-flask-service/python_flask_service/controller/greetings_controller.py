"""
Author: Rajkumar Venkatasamy
"""
import time

from flask import Blueprint, jsonify

greetings_blueprint = Blueprint('greetings', __name__)


@greetings_blueprint.route('/greetings', methods=['GET'])
def greetings():
    return jsonify("Greetings from python-flask-service"), 200


@greetings_blueprint.route('/belated-greetings', methods=['GET'])
def belated_greetings():
    """
    Artificial sleep time in seconds is introduced
    :return: JSON response : Belated greetings message
    """
    time.sleep(5)
    return jsonify("Belated Greetings from python-flask-service"), 200
