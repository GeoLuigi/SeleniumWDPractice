"""
This module contains the elements of the checkout step one page
"""

from selenium.webdriver.common.by import By
from src.pages.side_bar import Sidebar

class CheckoutStepOnePage(Sidebar):
    """
    This class contains the elements of the checkout step one page
    """
    def __init__(self, driver):
        super().__init__(driver)

        # Locators
        self.first_name_box = By.ID, "first-name"
        self.last_name_box = By.ID, "last-name"
        self.postal_code_box = By.ID, "postal-code"
        self.continue_btn = By.ID, "continue"

    def set_text_in_first_name_box(self, text):
        self.driver.find_element(*self.first_name_box).send_keys(text)

    def set_text_in_last_name_box(self, text):
        self.driver.find_element(*self.last_name_box).send_keys(text)

    def set_text_in_postal_code_box(self, text):
        self.driver.find_element(*self.postal_code_box).send_keys(text)

    def click_continue_button(self):
        self.driver.find_element(*self.continue_btn).click()
