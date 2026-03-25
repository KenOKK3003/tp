package doctorwho.logic.commands;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.Optional;

import doctorwho.commons.util.ToStringBuilder;
import doctorwho.logic.commands.exceptions.CommandException;
import doctorwho.model.Model;

/**
 * Lists appointments, optionally filtering by a specific appointment date.
 */
public class ListAppointmentCommand extends Command {

    public static final String COMMAND_WORD = "lsapt";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Lists appointments in ascending date-time order.\n"
            + "Parameters: [dt/DATE] (DATE in dd-MM-yyyy format)\n"
            + "Example: " + COMMAND_WORD + " dt/12-03-2026";

    private final Optional<LocalDate> appointmentDate;

    /**
     * Creates a {@code ListAppointmentCommand} that lists all appointments.
     */
    public ListAppointmentCommand() {
        this.appointmentDate = Optional.empty();
    }

    /**
     * Creates a {@code ListAppointmentCommand} that filters appointments by {@code appointmentDate}.
     */
    public ListAppointmentCommand(LocalDate appointmentDate) {
        requireNonNull(appointmentDate);
        this.appointmentDate = Optional.of(appointmentDate);
    }

    public Optional<LocalDate> getAppointmentDate() {
        return appointmentDate;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException("List appointment command execution is implemented in a later commit.");
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ListAppointmentCommand)) {
            return false;
        }

        ListAppointmentCommand otherCommand = (ListAppointmentCommand) other;
        return appointmentDate.equals(otherCommand.appointmentDate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("appointmentDate", appointmentDate)
                .toString();
    }
}
