import { Link } from "react-router-dom";
import './navbar.css'

export default function Navbar() {
    return (
        <nav className="nav justify-content-center">
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