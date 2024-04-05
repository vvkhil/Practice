import { useContext, useState } from "react";
import { AppContext } from "../contexts/contexts";
import { useNavigate } from "react-router-dom";
import { removeUserById} from "../api/userService";

export default function Profile() {
    const appContext = useContext(AppContext);

    const navigate = useNavigate();

    const [login, setLogin] = useState('');
    const [email, setEmail] = useState('');

    return (
        <section>
            <input
                placeholder='Логин'
                onChange={e => setLogin(e.target.value)}
            />
            <input
                placeholder='Почта'
                onChange={e => setEmail(e.target.value)}
            />
            <button
                onClick={logoutButtonOnClick}
            >
                Выйти
            </button>
            <button
                onClick={removeUserButtonOnClick}
            >
                Удалить аккаунт
            </button>
        </section>
    );

    async function logoutButtonOnClick() {
        appContext.removeCookie('userId');
        appContext.removeCookie('token');
        appContext.setIsAuthenticated(false);
        navigate('/');
    }

    async function removeUserButtonOnClick() {
        await removeUserById(appContext.user.id);
        logoutButtonOnClick();
    }
}