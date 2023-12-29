"""
This module contains the elements of the checkout complete page
"""

from selenium.webdriver.common.by import By
from src.pages.side_bar import Sidebar

class CheckoutCompletePage(Sidebar):
    """
    This class contains the elements of the checkout complete page
    """
    def __init__(self, driver):
        super().__init__(driver)

        # Locator
        self.back_to_products_btn = By.ID, "back-to-products"

    def click_back_to_products_button(self):
        self.driver.find_element(*self.back_to_products_btn).click()
