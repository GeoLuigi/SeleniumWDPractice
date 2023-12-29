from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class Sidebar:
    """
    This class contains the elements of the sidebar
    """

    def __init__(self, driver):
        self.driver = driver

        # Locators
        self.react_burger_menu_btn = By.ID, "react-burger-menu-btn"
        self.logout_btn = By.ID, "logout_sidebar_link"

    def click_react_burger_menu_button(self):
        self.driver.find_element(*self.react_burger_menu_btn).click()

    def click_logout_button(self):
        # Esperar a que el botón de logout sea cliclable antes de hacer clic
        wait = WebDriverWait(self.driver, 10)
        logout_button = wait.until(EC.element_to_be_clickable(self.logout_btn))
        logout_button.click()
