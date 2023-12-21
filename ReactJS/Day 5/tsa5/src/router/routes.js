import { Routes, Route } from 'react-router-dom';
import ParentToChild from '../functional/ParentToChild';
import ChildEx2 from '../functional/ChildEx2';

const router = <Routes>
    <Route path='/parent' element={ <ParentToChild/>}></Route>
    <Route path='/child' element={ <ChildEx2/>}></Route>

</Routes>

export default router;