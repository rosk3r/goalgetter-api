package ru.rosk3r.goalgetterapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SpringBootApplication
class GoalGetterApiApplication {

	private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-SSSSSS")
	private val version: String = dateTimeFormatter.format(LocalDateTime.now())

	@GetMapping("/version")
	fun getVersion(): String = version

}

fun main(args: Array<String>) {
	runApplication<GoalGetterApiApplication>(*args)
}
