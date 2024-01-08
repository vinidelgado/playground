package com.vini.playground

import com.vini.playground.navigation.ScreenRoutes
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class ScreenRoutesTest {
    @Test
    fun testHomeScreenRoute() {
        val homeScreen = ScreenRoutes.HomeScreen
        assertEquals("home_screen", homeScreen.route)
    }

    @Test
    fun testCardItauScreenRoute() {
        val cardItauScreen = ScreenRoutes.CardItauScreen
        assertEquals("card_itau_screen", cardItauScreen.route)
    }

    @Test
    fun testLoginLotusScreenRoute() {
        val loginLotusScreen = ScreenRoutes.LoginLotusScreen
        assertEquals("login_lotus_screen", loginLotusScreen.route)
    }

    @Test
    fun testEquality() {
        val homeScreen1 = ScreenRoutes.HomeScreen
        val homeScreen2 = ScreenRoutes.HomeScreen
        val cardItauScreen = ScreenRoutes.CardItauScreen

        assertEquals(homeScreen1, homeScreen2)
        assertNotEquals(homeScreen1,cardItauScreen)
    }
}