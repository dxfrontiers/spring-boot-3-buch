import {useEffect, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import springBootLogo from './assets/Spring_Boot.svg'
import './App.css'
import TaskList from "./components/TaskList.jsx";

function App() {
  const [count, setCount] = useState(0)
  const [tasks, setTasks] = useState([])

  useEffect(() => {
fetch("/api/v1/tasks")
  .then(response => response.json())
  .then(response => {
    setTasks(response)
  })
  }, []);

  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={springBootLogo} className="logo" alt="SpringBoot logo" />
        </a>
      </div>
      <h1>Vite + React + SpringBoot</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <div className="card">
        <TaskList tasks={tasks} />
      </div>
      <p className="read-the-docs">
        Click on the Vite, React and SpringBoot logos to learn more
      </p>
    </>
  )
}

export default App
