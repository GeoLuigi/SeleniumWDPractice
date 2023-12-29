"""
This is a test case to verify the login functionality of the SauceDemo application
"""
import os
import sys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
sys.path.append(os.path.join(os.path.dirname(__file__), "..", ".."))



class LoginPage:
    """
    This class contains the elements of the login page
    """
    def __init__(self, driver):
        self.driver = driver

        # Locators
        self.username_box = (By.ID, "user-name")
        self.password_box = (By.ID, "password")
        self.login_btn = (By.ID, "login-button")

    def set_text_in_username_box(self, text):
        username_element = WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located(self.username_box)
        )
        username_element.send_keys(text)

    def set_text_in_password_box(self, text):
        password_element = WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located(self.password_box)
        )
        password_element.send_keys(text)

    def click_login_button(self):
        login_button = WebDriverWait(self.driver, 10).until(
            EC.element_to_be_clickable(self.login_btn)
        )
        login_button.click()
