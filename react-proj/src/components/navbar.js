import { Link } from "react-router-dom";

export default function Navbar() {
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <ul className="nav nav-pills">
                <li className="nav-item">
                    <Link to={`/signin`}>Войти</Link>
                </li>
                <li className="nav-item"> 
                    <Link to={`/signup`}>Регистрация</Link>
                </li>
            </ul>
        </nav>
    );
}