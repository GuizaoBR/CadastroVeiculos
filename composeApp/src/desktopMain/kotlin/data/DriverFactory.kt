package data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.example.VeiculosDatabase
import java.io.File

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        val driver = JdbcSqliteDriver(url = "jdbc:sqlite:VeiculosDatabase.db")
        if (!File("VeiculosDatabase.db").exists()) {
            VeiculosDatabase.Schema.create(driver)
        }
        return driver
    }
}