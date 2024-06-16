"use client";

import AuthService from "@/app/api/auth-service";
import { EmailIcon } from "@/components/icons/email-icon";
import { PasswordIcon } from "@/components/icons/password-icon";
import { PhoneIcon } from "@/components/icons/phone-icon";
import { RepeatPasswordIcon } from "@/components/icons/repeat-password-icon";
import { UserIcon } from "@/components/icons/user-icon";
import { Button } from "@/components/ui/button";
import { Field } from "@/components/ui/field";
import { useState } from "react";
import { useRouter } from "next/navigation";
import UserService from "@/app/api/user-service";
import authorizedUserStore, { IAuthorizedUser } from "@/store/authorizedUser";
import { IUserRole } from "@/types";
import toast, { Toaster } from "react-hot-toast";
import { saveToken } from "@/utils/save-token";
import { loadToken } from "@/utils/load-token";

const AuthPage = () => {
  const [stage, setStage] = useState("login");

  const [formData, setFormData] = useState({
    username: "",
    phone: "",
    email: "",
    password: "",
    repeatPassword: "",
  });

  const router = useRouter();

  const handleChange = (e: any) => {
    const { name, value } = e.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleLogin = async (event: MouseEvent) => {
    event.preventDefault();
    const loginData = {
      phone: "+7" + formData.phone,
      password: formData.password,
    };
    try {
      const response = await AuthService.login(loginData);
      if (response.status === 200) {
        toast.success("Вы успешно вошли в свой аккаунт");
        router.push("/");
        // localStorage.setItem("token", response.data.token);
        saveToken(response.data.token);
        const userInfo = await UserService.getAllUserInfo(
          response.data.user_id,
        );
        const userInfoData: IAuthorizedUser = {
          id: response.data.user_id,
          role: response.data.role as IUserRole,
          ...userInfo.data,
        };

        authorizedUserStore.setUser(userInfoData);
      }
    } catch (error) {
      console.error(error);
      if (error.response && error.response.status === 400) {
        toast.error(error.response.data, {
          position: "top-center",
        });
      }
    }
  };

  const handleRegister = async (e: any) => {
    e.preventDefault();
    if (formData.password !== formData.repeatPassword) {
      alert("Пароли не совпадают");
      return;
    }
    const registerData = {
      username: formData.username,
      phone: "+7" + formData.phone,
      email: formData.email,
      password: formData.password,
    };
    try {
      const response = await AuthService.register(registerData);
      if (response.status === 200) {
        toast.success("Регистрация прошла успешно. Войдите в аккаунт");
        setStage("login");
      }
    } catch (error) {
      console.error(error);
      if (error.response && error.response.status === 400) {
        toast.error(error.response.data, {
          position: "top-center",
        });
      }
    }
  };

  return (
    <div
      style={{ minHeight: "calc(100dvh - 240px)" }}
      className="flex items-center justify-center bg-[#F6F6F6]"
    >
      <title>Авторизация</title>
      <form
        className="bg-white rounded-xl p-10 shadow-2xl flex flex-col items-center gap-8 w-[30em] my-20"
        onSubmit={stage === "register" ? handleRegister : undefined}
      >
        <h2 className="text-black font-bold text-2xl">
          {stage === "login" ? "Войти в профиль" : "Регистрация"}
        </h2>
        <div className="flex flex-col gap-3 w-full">
          {stage === "login" ? (
            <>
              <Field
                icon={<PhoneIcon />}
                startContent="+7"
                placeholder="000 000 00-00"
                name="phone"
                value={formData.phone}
                onChange={handleChange}
              />
              <Field
                icon={<PasswordIcon />}
                placeholder="Введите пароль"
                name="password"
                type="password"
                value={formData.password}
                onChange={handleChange}
              />
            </>
          ) : (
            <>
              <Field
                icon={<UserIcon />}
                placeholder="Имя"
                name="username"
                value={formData.username}
                onChange={handleChange}
              />
              <Field
                icon={<PhoneIcon />}
                startContent="+7"
                placeholder="000 000 00-00"
                name="phone"
                value={formData.phone}
                onChange={handleChange}
              />
              <Field
                icon={<EmailIcon />}
                placeholder="Введите e-mail"
                name="email"
                value={formData.email}
                onChange={handleChange}
              />
              <Field
                type="password"
                icon={<PasswordIcon />}
                placeholder="Введите пароль"
                name="password"
                value={formData.password}
                onChange={handleChange}
              />
              <Field
                type="password"
                icon={<RepeatPasswordIcon />}
                placeholder="Повторите пароль"
                name="repeatPassword"
                value={formData.repeatPassword}
                onChange={handleChange}
              />
            </>
          )}
        </div>
        <div className="flex flex-col gap-4 w-full">
          {stage === "login" ? (
            <>
              <Button
                color="dark"
                onClick={(event: any) => {
                  handleLogin(event);
                }}
              >
                Войти
              </Button>
              <span className="text-center w-full">
                <Button
                  variant="link"
                  href="#"
                  onClick={() => setStage("register")}
                >
                  Зарегистрироваться
                </Button>
              </span>
            </>
          ) : (
            <>
              <Button color="dark" type="submit">
                Зарегистрироваться
              </Button>
              <span className="text-center w-full">
                <Button
                  variant="link"
                  href="#"
                  onClick={() => setStage("login")}
                >
                  Есть аккаунт? Войти
                </Button>
              </span>
            </>
          )}
        </div>
      </form>
    </div>
  );
};

export default AuthPage;
