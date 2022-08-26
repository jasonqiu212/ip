package cheese.command;

import cheese.exception.CheeseException;
import cheese.storage.Storage;
import cheese.ui.Ui;
import cheese.task.Task;
import cheese.data.TaskList;

public class DeleteCommand extends Command {
  private int taskIndex;

  public DeleteCommand(int givenIndex) {
    taskIndex = givenIndex - 1;
  }

  @Override
  public void execute(TaskList taskList, Storage storage, Ui ui) throws CheeseException {
    Task deletedTask = taskList.delete(taskIndex);
    ui.showDeleteTask(deletedTask, taskList.getSize());
    storage.save(taskList);
  }
}