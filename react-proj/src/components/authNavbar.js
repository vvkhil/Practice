import { Link } from "react-router-dom";

export default function AuthNavbar() {
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
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