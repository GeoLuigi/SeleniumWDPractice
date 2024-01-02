"""
This is a test case to verify the login functionality of the SauceDemo application
"""
import unittest
import os
import sys
from selenium.webdriver.common.by import By
from src.browsers.browser_setup import BrowserSetup
from src.pages.login_page import LoginPage
from src.pages.inventory_page import InventoryPage
from src.pages.cart_page import CartPage
from src.pages.check_out_step_one_page import CheckoutStepOnePage
from src.pages.check_out_step_two_page import CheckoutStepTwoPage
from src.pages.check_out_complete_page import CheckoutCompletePage

sys.path.append(os.path.join(os.path.dirname(__file__), "..", ".."))


class TestLogIn(unittest.TestCase):
    """
    This class contains the test cases for the login functionality of the SauceDemo application
    """

    driver = BrowserSetup().initialize_browser("firefox")

    def test_end_to_end(self):

        login_page = LoginPage(self.driver)
        inventory_page = InventoryPage(self.driver)
        cart_page = CartPage(self.driver)
        checkout_step_one_page = CheckoutStepOnePage(self.driver)
        checkout_step_two_page = CheckoutStepTwoPage(self.driver)
        check_out_complete_page = CheckoutCompletePage(self.driver)


        # Login Page
        self.driver.get("https://www.saucedemo.com/")
        username_field = self.driver.find_element(By.ID, "user-name").get_attribute("placeholder")
        password_field = self.driver.find_element(By.ID, "password").get_attribute("placeholder")

        self.assertEqual(username_field, "Username", "Placeholder for username incorrect.")
        self.assertEqual(password_field, "Password", "Placeholder for password incorrect.")
        self.assertEqual(self.driver.current_url, "https://www.saucedemo.com/")

        login_page.set_text_in_username_box("standard_user")
        login_page.set_text_in_password_box("secret_sauce")
        login_page.click_login_button()

        # Inventory Page
        self.assertEqual(self.driver.current_url, "https://www.saucedemo.com/inventory.html")
        inventory_page.click_onesie_clothing_button()
        inventory_page.click_fleece_jacket_clothing_button()
        inventory_page.click_shopping_cart_button()

        # Cart Page
        self.assertEqual(self.driver.current_url, "https://www.saucedemo.com/cart.html")
        cart_page.click_checkout_button()

        # Checkout Step One Page
        self.assertEqual(self.driver.current_url,"https://www.saucedemo.com/checkout-step-one.html")
        checkout_step_one_page.set_text_in_first_name_box("John")
        checkout_step_one_page.set_text_in_last_name_box("Doe")
        checkout_step_one_page.set_text_in_postal_code_box("12345")
        checkout_step_one_page.click_continue_button()

        # Checkout Step Two Page
        self.assertEqual(self.driver.current_url,"https://www.saucedemo.com/checkout-step-two.html")
        checkout_step_two_page.click_finish_button()

        # Checkout Complete Page
        self.assertEqual(self.driver.current_url,"https://www.saucedemo.com/checkout-complete.html")
        check_out_complete_page.click_back_to_products_button()

        # Inventory Page (again)
        self.assertEqual(self.driver.current_url, "https://www.saucedemo.com/inventory.html")
        inventory_page.click_react_burger_menu_button()
        inventory_page.click_logout_button()

    @classmethod
    def tearDown(cls):
        cls.driver.close()
        cls.driver.quit()


if __name__ == '__main__':
    unittest.main()
