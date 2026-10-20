package com.example.tenantmanagementsystem

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ExampleUnitTest {

    @Before
    fun setUp() {
        TenantRepository.tenants.clear()
    }

    @Test
    fun testTenantSummaryFormat() {
        val tenant = Tenant(name = "Alice", phone = "0711223344", rent = "15000")
        val expected = "Tenant: Alice\nPhone: 0711223344\nRent paid: KSh 15000"
        assertEquals(expected, tenant.summary())
    }

    @Test
    fun testTenantFormattedRent() {
        val tenant = Tenant(rent = "20000")
        assertEquals("KSh 20000", tenant.formattedRent())
    }

    @Test
    fun testAddTenantIncreasesCount() {
        val initialCount = TenantRepository.tenants.size
        TenantRepository.addTenant(Tenant(name = "Bob Smith", phone = "0799887766", rent = "12000"))
        val newCount = TenantRepository.tenants.size
        assertEquals(initialCount + 1, newCount)
    }

    @Test
    fun testTotalRentCalculation() {
        TenantRepository.addTenant(Tenant(name = "Alice", phone = "0711223344", rent = "15000"))
        TenantRepository.addTenant(Tenant(name = "Bob", phone = "0722334455", rent = "25000"))
        val expectedTotal = 40000.0
        assertEquals(expectedTotal, TenantRepository.totalRent(), 0.001)
    }
}
