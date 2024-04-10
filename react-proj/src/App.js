import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Root from './routes/root';
import NotFound from './routes/notFound'
import Profile from './routes/profile';
import Signup from './routes/signup';
import Signin from './routes/signin';
import Shops from "./routes/shops";
import Shoes from "./routes/shoes";
import GetShoesByShop, {loader as getshopShoesByShopLoader} from "./routes/getShoesByShop";
import AddShoeToShop, {loader as addShoeToShopLoader} from "./routes/addShoeToShop";
import RemoveShoeFromShop, {loader as removeShoeFromShopLoader} from "./routes/removeShoeFromShop";
import ShopsUpdate, {loader as shopUpdateLoader} from "./routes/shopsUpdate";
import ShoesUpdate, {loader as shoeUpdateLoader} from "./routes/shoesUpdate";
import BaskShopAdd from "./routes/baskShopAdd";
import BaskShoeAdd from "./routes/baskShoeAdd";
import { useCookies } from "react-cookie";
import { useEffect, useState } from "react";
import { AppContext } from "../src/contexts/contexts";
import { getUserById } from "../src/api/userService";
import axios from "axios";

export default function App() {
  const [cookies, setCookie, removeCookie] = useCookies(['id', 'token']);
  const [isAuthenticated, setIsAuthenticated] = useState(cookies.token !== undefined);
  const [user, setUser] = useState({});

  useEffect(() => {
    if (cookies.userId !== undefined) {
      getUserById(cookies.userId).then(user => setUser(user));
    }

    if (cookies.token !== undefined) {
      axios.defaults.headers.common['Authorization'] = `Bearer ${cookies.token}`;
    }
    else {
      axios.defaults.headers.common['Authorization'] = '';
    }
  }, [isAuthenticated, cookies.token, cookies.userId]);

  const state = {
    setCookie,
    removeCookie,
    isAuthenticated,
    setIsAuthenticated,
    user,
    setUser
  };

  const authenticatedRouter = createBrowserRouter([
    {
      path: "/",
      element: <Root/>,
      errorElement: <NotFound />,
      children: [
        {
          path: "/shops",
          element: <Shops />,
        },
        {
          path: "/shops/add",
          element: <BaskShopAdd />
        },
        {
          path: "/shops/update/:shopId",
          element: <ShopsUpdate />,
          loader: shopUpdateLoader
        },
        {
          path: "/shops/add/:shopId",
          element: <AddShoeToShop />,
          loader: addShoeToShopLoader
        },
        {
          path: "/shops/delete/:shopId",
          element: <RemoveShoeFromShop />,
          loader: removeShoeFromShopLoader
        },
        {
          path: "/shops/get/:shopId",
          element: <GetShoesByShop />,
          loader: getshopShoesByShopLoader
        },
        {
          path: "/shoes",
          element: <Shoes />,
        },
        {
          path: "/shoes/add",
          element: <BaskShoeAdd />
        },
        {
          path: "/shoes/update/:shoeId",
          element: <ShoesUpdate />,
          loader: shoeUpdateLoader
        },
        {
          path: "/profile",
          element: <Profile />
        }
      ]
    }
  ]);

  const anonymousRouter = createBrowserRouter([
    {
      path: "/",
      element: <Root/>,
      errorElement: <NotFound />,
      children: [
        {
          path: "/signup",
          element: <Signup />
        },
        {
          path: "/signin",
          element: <Signin />
        }
      ]
    }
  ]);

  return (
    <AppContext.Provider value={state}>
      <RouterProvider router={isAuthenticated ? authenticatedRouter : anonymousRouter} />
    </AppContext.Provider>
  );
}