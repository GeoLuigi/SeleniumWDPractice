"""
This module contains the elements of the checkout step two page
"""

from selenium.webdriver.common.by import By
from src.pages.side_bar import Sidebar

class CheckoutStepTwoPage(Sidebar):
    """
    This class contains the elements of the checkout step two page
    """
    def __init__(self, driver):
        super().__init__(driver)

        # Locator
        self.finish_btn = By.ID, "finish"

    def click_finish_button(self):
        self.driver.find_element(*self.finish_btn).click()
