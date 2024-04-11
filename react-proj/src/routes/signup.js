import { useContext, useState } from "react";
import { signUp } from "../api/authService";
import { AppContext } from "../contexts/contexts";
import { useNavigate } from "react-router-dom";
import './signup.css'

export default function Signup() {
    const appContext = useContext(AppContext);

    const navigate = useNavigate();

    const [login, setLogin] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const isValidEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;

    return (
        <section className="form-sign-up">
            <input
                className="form-control" 
                placeholder="Login"
                type="login"
                onChange={e => setLogin(e.target.value)}
            />
            <input
                className="form-control" 
                placeholder="Email"
                type="email"
                onChange={e => 
                    {
                        if(e.target?.value && e.target.value.match(isValidEmail)){
                            console.log('valid')
                            setEmail(e.target.value)
                        }else{
                            console.log('invalid')
                        }
                    }
                }
            />
            <input
                className="form-control" 
                placeholder="Пароль"
                type="password"
                onChange={e => setPassword(e.target.value)}
            />
            <button
                className="btn btn-info"
                onClick={signupButtonOnClick}
            >
                Register
            </button>
        </section>
    );

    async function signupButtonOnClick() {
        console.log(email)
        let data = null;
        if (email == "") {
            alert("Please enter valid email!")
        } else {
            data = await signUp(null, login, email, password);
        }
        appContext.setCookie('userId', data.id);
        appContext.setCookie('token', data.token);
        appContext.setIsAuthenticated(true);
        navigate('/');
    }
}