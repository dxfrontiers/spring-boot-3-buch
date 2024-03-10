import './TaskList.css'


export default function TaskList({tasks}) {
  return (
    <table className="tasklist">
      <thead>
        <tr>
          <th colSpan="2">Task Title</th>
        </tr>
      </thead>
      {tasks.map(task => {
        return (<tr id={"task-" + task.id}>
          <td><input type="checkbox" checked={task.done} /> </td>
          <td className={task.done ? "done" : ""}>{task.title}</td>
        </tr>)
      })}
    </table>
  )
}