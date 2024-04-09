import { useContext, useEffect, useState } from "react";
import { AppContext } from "../contexts/contexts";
import { useNavigate } from "react-router-dom";
import { removeUserById } from "../api/userService";

export default function Profile() {
    const appContext = useContext(AppContext);

    const navigate = useNavigate();
    
    const [login, setLogin] = useState(appContext.user.login);
    const [email, setEmail] = useState(appContext.user.email);
    const [password, setPassword] = useState(appContext.user.password);

    useEffect(() => {
        setLogin(appContext.user.login);
        setEmail(appContext.user.email);
        setPassword(appContext.user.password);
    }, [appContext.user.login, appContext.user.email, appContext.user.password])

    return (
        <section className="profile-container">
            <div className="profile-card">
                <input
                    placeholder='Логин'
                    value={login}
                    onChange={e => setLogin(e.target.value)}
                />
                <input
                    placeholder='Email'
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                />
                <input
                    placeholder='Пароль'
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                />
                {/* <button
                    className="background-color-green"
                    onClick={updateUserButtonOnClick}
                >
                    Редактировать
                </button> */}
                <button
                    className="background-color-gray"
                    onClick={logoutButtonOnClick}
                >
                    Выйти
                </button>
                <button
                    className="background-color-red"
                    onClick={removeUserButtonOnClick}
                >
                    Удалить аккаунт
                </button>
            </div>
        </section>
    );

    // async function updateUserButtonOnClick() {
    //     const userApp = await getUserById(appContext.user.id);
    //     console.log(userApp);
    //     console.log(userApp.getRoleId)
    //     const roleId = userApp.roleId;
    //     console.log(roleId)
    //     console.log(appContext.user.id, login, email, password, roleId);
    //     await updateUser(appContext.user.id, login, email, password, roleId);
    //     const user = JSON.parse(JSON.stringify(appContext.user));
    //     user.login = login;
    //     user.email = email;
    //     user.password = password;
    //     appContext.setUser(user);
    // }

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