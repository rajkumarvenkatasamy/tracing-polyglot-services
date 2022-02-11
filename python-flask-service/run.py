"""
Author: Rajkumar Venkatasamy

Main Function
"""
from python_flask_service import python_flask_service

if __name__ == "__main__":

    python_flask_service.run(host='0.0.0.0', port=5000, use_reloader=False)
