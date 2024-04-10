import { Link } from "react-router-dom";
import './navbar.css'

export default function AuthNavbar() {
    return (
        <nav className="nav justify-content-center">
            <ul className="nav nav-pills">
                <li className="nav-item">
                    <Link to={`/profile`}>Профиль</Link>
                </li>
                <li className="nav-item">
                    <Link to={`/shops`}>Магазины</Link>
                </li>
                <li className="nav-item">
                    <Link to={`/shoes`}>Кроссовки</Link>
                </li>
            </ul>
        </nav>
    );
}