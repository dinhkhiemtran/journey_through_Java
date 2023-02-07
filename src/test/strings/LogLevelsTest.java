package test.strings;

import main.strings.LogLevels;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LogLevelsTest {

    @Test
    public void message_with_leading_and_trailing_white_space() {
        assertThat(LogLevels.messageSolution1("[WARNING]:   \tTimezone not set  \r\n")).isEqualTo("Timezone not set");
    }

    @Test
    public void info_message() {
        assertThat(LogLevels.messageSolution1("[INFO]: File moved")).isEqualTo("File moved");
    }

    @Test
    public void error_message() {
        assertThat(LogLevels.messageSolution1("[ERROR]: Stack overflow")).isEqualTo("Stack overflow");
    }

    @Test
    public void reformat_with_leading_and_trailing_white_space() {
        assertThat(LogLevels.reformatSolution1("[ERROR]: \t Corrupt disk\t \t \r\n")).isEqualTo("Corrupt disk (error)");
    }

    @Test
    public void info_log_level() {
        assertThat(LogLevels.logLevelSolution1("[INFO]: Timezone changed")).isEqualTo("info");
    }

    @Test
    public void error_reformat() {
        assertThat(LogLevels.reformatSolution1("[ERROR]: Segmentation fault")).isEqualTo("Segmentation fault (error)");
    }

    @Test
    public void error_log_level() {
        assertThat(LogLevels.logLevelSolution1("[ERROR]: Disk full")).isEqualTo("error");
    }

    @Test
    public void info_reformat() {
        assertThat(LogLevels.reformatSolution1("[INFO]: Disk defragmented")).isEqualTo("Disk defragmented (info)");
    }

    @Test
    public void warning_reformat() {
        assertThat(LogLevels.reformatSolution2("[WARNING]: Decreased performance")).isEqualTo("Decreased performance (warning)");
    }

    @Test
    public void warning_log_level() {
        assertThat(LogLevels.logLevelSolution1("[WARNING]: Unsafe password")).isEqualTo("warning");
    }

    @Test
    public void warning_message() {
        assertThat(LogLevels.messageSolution1("[WARNING]: Disk almost full")).isEqualTo("Disk almost full");
    }

}