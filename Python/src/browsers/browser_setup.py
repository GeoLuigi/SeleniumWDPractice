"""
This class contains the methods to initialize the browser
"""

from selenium import webdriver

class BrowserSetup:
    """
    This class contains the methods to initialize the browser
    """

    def __init__(self):
        pass

    def __str__(self):
        pass

    @staticmethod
    def initialize_browser(browser_name : str):
        """
        This method initializes the browser
        """
        if browser_name.lower() == "chrome":
            options = webdriver.ChromeOptions()
            options.add_argument("--incognito")
            options.add_argument("--remote-allow-origins=*")
            options.add_argument("--disable-blink-features=AutomationControlled")
            driver = webdriver.Chrome(options=options)

        elif browser_name.lower() == "firefox":
            options = webdriver.FirefoxOptions()
            options.add_argument("-private")
            driver = webdriver.Firefox(options=options)

        elif browser_name.lower() == "edge":
            driver = webdriver.Edge()

        else:
            raise ValueError("Invalid browser name: " + browser_name)

        return driver
