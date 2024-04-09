import { useContext } from "react";
import Navbar from "../components/navbar";
import AuthNavbar from "../components/authNavbar";
import { Outlet } from "react-router-dom";
import { AppContext } from "../contexts/contexts";

export default function Root() {
    const appContext = useContext(AppContext);

    return (
        <main>
            { !appContext.isAuthenticated && <Navbar />}
            { appContext.isAuthenticated && <AuthNavbar />}
            <Outlet />
        </main>
    );
}