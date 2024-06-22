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
import toast from "react-hot-toast";
import { saveToken } from "@/utils/save-token";
import { useMutation } from "@tanstack/react-query";
import { useAmp } from "next/amp";
import { AuthRequest, RegisterRequest } from "../api/[models]/authRequests";
import { IUser, IUserRole } from "@/types";

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
  const loginMutation = useMutation({
    mutationKey: ["login"],
    mutationFn: async (loginData: AuthRequest) => {
      try {
        const response = await AuthService.login(loginData);
        saveToken(
          response.data.token,
          response.data.user_id,
          response.data.role as IUserRole,
        );
      } catch (error) {
        if (
          error.response &&
          error.response.data &&
          error.response.data.message
        ) {
          // Если сервер возвращает сообщение об ошибке
          throw new Error(error.response.data.message);
        } else {
          // Если сервер не возвращает сообщение об ошибке
          throw new Error("Произошла ошибка при входе. Попробуйте снова.");
        }
      }
    },
    onSuccess: () => {
      router.push("/");

      toast.success("Вы успешно вошли в аккаунт!");
    },
    onError: (error) => {
      // Проверяем, есть ли у ошибки сообщение от сервера
      const errorMessage =
        error.response?.data?.message || error.message || "Произошла ошибка";
      toast.error(errorMessage);
    },
  });

  const regitserMutation = useMutation({
    mutationKey: ["register"],
    mutationFn: async (registerData: RegisterRequest) => {
      await AuthService.register(registerData);
    },
    onSuccess: () => {
      setStage("login");
      toast.success(
        "Вы успешно создали аккаунт\nТеперь вы можете войти в аккаунт",
      );
    },
    onError: (err) => {
      toast.error(err.name);
    },
  });

  const handleLogin = (event: any) => {
    event.preventDefault();
    loginMutation.mutate({
      phone: "+7" + formData.phone,
      password: formData.password,
    });
  };

  const handleRegister = (event: any) => {
    event.preventDefault();
    regitserMutation.mutate({
      username: formData.username,
      phone: "+7" + formData.phone,
      email: formData.email,
      password: formData.password,
    });
  };

  return (
    <div
      style={{ minHeight: "calc(100dvh - 240px)" }}
      className="flex items-center justify-center bg-[#F6F6F6]"
    >
      <title>Авторизация</title>
      <form className="my-20 flex w-[30em] flex-col items-center gap-8 rounded-xl bg-white p-10 shadow-2xl">
        <h2 className="text-2xl font-bold text-black">
          {stage === "login" ? "Войти в профиль" : "Регистрация"}
        </h2>
        <div className="flex w-full flex-col gap-3">
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
        <div className="flex w-full flex-col gap-4">
          {stage === "login" ? (
            <>
              <Button
                disabled={loginMutation.isPending}
                isLoading={loginMutation.isPending}
                color="dark"
                type="button"
                onClick={(e) => handleLogin(e)}
              >
                Войти
              </Button>
              <span className="w-full text-center">
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
              <Button
                color="dark"
                type="button"
                onClick={(e) => handleRegister(e)}
              >
                Зарегистрироваться
              </Button>
              <span className="w-full text-center">
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
