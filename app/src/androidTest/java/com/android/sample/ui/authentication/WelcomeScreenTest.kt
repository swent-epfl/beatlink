package com.android.sample.ui.authentication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.sample.ui.navigation.NavigationActions
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class WelcomeScreenTest {

  @get:Rule val composeTestRule = createComposeRule()

  private lateinit var navigationActions: NavigationActions

  @Before
  fun setUp() {
    navigationActions = mock(NavigationActions::class.java)
  }

  @Test
  fun displayAllComponents() {
    composeTestRule.setContent { WelcomeScreen(navigationActions) }

    // Check if the app logo is displayed
    composeTestRule.onNodeWithTag("appLogo").assertIsDisplayed()

    // Check if the app name is displayed correctly
    composeTestRule.onNodeWithTag("appName").assertIsDisplayed().assertTextContains("BeatLink")

    // Check if the subtitle text is displayed
    composeTestRule
        .onNodeWithTag("appText")
        .assertIsDisplayed()
        .assertTextContains("Link Up Through Music")

    // Check if the sign up button is displayed
    composeTestRule.onNodeWithTag("signUpButton").assertIsDisplayed()

    // Check if the login button is displayed
    composeTestRule.onNodeWithTag("loginButton").assertIsDisplayed()
  }

  @Test
  fun verifyLoginButtonNavigatesToLoginScreen() {
    composeTestRule.setContent { WelcomeScreen(navigationActions) }

    // Perform click action on the sign-in button
    composeTestRule.onNodeWithTag("loginButton").performClick()

    // TODO: Verify the expected behavior when the button is clicked
  }
}
