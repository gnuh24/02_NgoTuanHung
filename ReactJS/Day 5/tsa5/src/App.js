import logo from './logo.svg';
import './App.css';
import ParentToChild from './functional/ParentToChild';
import context from './functional/context';

function App() {
  return (
    <context.Provider >
      <div className="App">
        <header className="App-header">
          <ParentToChild />
        </header>
      </div>
    </context.Provider>
    
  );
}

export default App;
