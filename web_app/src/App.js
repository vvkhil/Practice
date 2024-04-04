import React, { useEffect, useState } from 'react';
import './App.css';
import {
    RouterProvider,
    createBrowserRouter
} from "react-router-dom";
import Root from './routes/root';
import Signup from './routes/signup';
import Signin from './routes/signin';
import { useCookies } from 'react-cookie'
import axios from "axios"


const router = createBrowserRouter([
    {
      path: "/",
      element: <Root />,
      errorElement: <App />,
      children: [
        {
            path: "/signin",
            element: <Signin />
        },
        {
            path: "/signup",
            element: <Signup />
        }
      ]
    }
]);

function App() {

    const [cookies] = useCookies(['jwt_token', 'user']);

    if (cookies.jwt_token !== undefined) {
        axios.defaults.headers.common['Authorization'] = 'Bearer ' + cookies.jwt_token;
    }
    else {
        axios.defaults.headers.common['Authorization'] = '';
    }

    return (
        <RouterProvider router={router} >

        </RouterProvider>
  );
}

export default App;