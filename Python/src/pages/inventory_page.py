"""
This module contains the elements of the inventory page
"""

from selenium.webdriver.common.by import By
from src.pages.side_bar import Sidebar

class InventoryPage(Sidebar):
    """
    This class contains the elements of the inventory page
    """
    def __init__(self, driver):
        super().__init__(driver)

        # Locators
        self.onesie_clothing_btn = By.ID, "add-to-cart-sauce-labs-onesie"
        self.fleece_jacket_clothing_btn = By.ID, "add-to-cart-sauce-labs-fleece-jacket"
        self.shopping_cart_btn = By.ID, "shopping_cart_container"

    def click_onesie_clothing_button(self):
        self.driver.find_element(*self.onesie_clothing_btn).click()

    def click_fleece_jacket_clothing_button(self):
        self.driver.find_element(*self.fleece_jacket_clothing_btn).click()

    def click_shopping_cart_button(self):
        self.driver.find_element(*self.shopping_cart_btn).click()
