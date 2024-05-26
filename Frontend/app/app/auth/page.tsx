"use client";

import { EmailIcon } from "@/components/icons/email-icon";
import { PasswordIcon } from "@/components/icons/password-icon";
import { PhoneIcon } from "@/components/icons/phone-icon";
import { RepeatPasswordIcon } from "@/components/icons/repeat-password-icon";
import { UserIcon } from "@/components/icons/user-icon";
import { Button } from "@/components/ui/button";
import { Field } from "@/components/ui/field";
import Link from "next/link";
import { useState } from "react";

const AuthPage = () => {
  const [stage, setStage] = useState("login");
  return (
    <div
      style={{ minHeight: "calc(100dvh - 240px)" }}
      className="flex items-center justify-center bg-[#F6F6F6]"
    >
      <form className="bg-white rounded-xl p-10 shadow-2xl flex flex-col items-center gap-8 w-1/6">
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
              />
              <Field icon={<PasswordIcon />} placeholder="Введите пароль" />
            </>
          ) : (
            <>
              <Field icon={<UserIcon />} placeholder="Введите имя" />
              <Field
                icon={<PhoneIcon />}
                startContent="+7"
                placeholder="000 000 00-00"
              />
              <Field icon={<EmailIcon />} placeholder="Введите e-mail" />
              <Field icon={<PasswordIcon />} placeholder="Введите пароль" />
              <Field
                icon={<RepeatPasswordIcon />}
                placeholder="Повторите пароль"
              />
            </>
          )}
        </div>
        <div className="flex flex-col gap-4 w-full">
          {stage === "login" ? (
            <>
              <Button color="dark">Войти</Button>
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
              <Button color="dark">Зарегистрироваться</Button>
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
