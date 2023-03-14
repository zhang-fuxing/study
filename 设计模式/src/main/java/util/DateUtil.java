package util;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.time.*;

/**
 * @author  zhangfx
 * @date    2023/2/6
 */
public class DateUtil {
	public static java.util.Date localDateTimeToDate(@NotNull LocalDateTime localDateTime) {
		Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}
	
	public static java.util.Date localDateToDate(@NotNull LocalDate localDate) {
		Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}
	
	public static java.util.Date localTimeToDate(@NotNull LocalTime localTime) {
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
		return localDateTimeToDate(localDateTime);
	}
	public static LocalDateTime dateToLocalDateTime(@NotNull java.util.Date date) {
		return getZoneDateTime(date).toLocalDateTime();
	}
	
	public static LocalDate dateToLocalDate(@NotNull java.util.Date date) {
		return getZoneDateTime(date).toLocalDate();
	}
	
	public static LocalTime dateToLocalTime(@NotNull java.util.Date date) {
		return getZoneDateTime(date).toLocalTime();
	}
	private static ZonedDateTime getZoneDateTime(@NotNull java.util.Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault());
	}
}
