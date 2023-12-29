"""
This module contains the elements of the cart page
"""

from selenium.webdriver.common.by import By
from src.pages.side_bar import Sidebar

class CartPage(Sidebar):
    """
    This class contains the elements of the cart page
    """
    def __init__(self, driver):
        super().__init__(driver)

        # Locator
        self.checkout_btn = (By.ID, "checkout")

    def click_checkout_button(self):
        self.driver.find_element(*self.checkout_btn).click()
