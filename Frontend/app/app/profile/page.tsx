"use client";

import { DeliveryItem } from "@/components/delivery/delivery-item";
import { DeliveryList } from "@/components/delivery/delivery-panel";
import { BankCardIcon } from "@/components/icons/bank-card-icon";
import { CalendarIcon } from "@/components/icons/calendar-icon";
import { EmailIcon } from "@/components/icons/email-icon";
import { PasswordIcon } from "@/components/icons/password-icon";
import { PhoneIcon } from "@/components/icons/phone-icon";
import { RepeatPasswordIcon } from "@/components/icons/repeat-password-icon";
import { UserIcon } from "@/components/icons/user-icon";
import { Button } from "@/components/ui/button";
import { Field } from "@/components/ui/field";
import { useState } from "react";

const AuthPage = () => {
  // FIXME: прописать входные данные
  const [username, setUsername] = useState<string>("Василий");
  const [phone, setPhone] = useState<string>("985 000 9243");
  const [email, setEmail] = useState<string>("khudobin_v@icloud.com");

  const [oldPassword, setOldPassword] = useState<string>("");
  const [newPassword, setNewPassword] = useState<string>("");
  const [repeatedNewPassword, setRepeatedNewPassword] = useState<string>("");

  const [cardNumber, setCardNumber] = useState<string>("**** **** **** 8442");
  const [cardDate, setCardDate] = useState<string>("02 / 27");
  const [CVC, setCVC] = useState<string>("* * *");
  return (
    <div
      style={{ minHeight: "calc(100dvh - 240px)" }}
      className="flex py-10 bg-[#F6F6F6]"
    >
      <title>Профиль</title>
      <div className="w-full grid grid-cols-4 px-20 gap-6 h-full">
        <div className="col-span-1 flex flex-col gap-6">
          <div className="bg-white rounded-xl p-6">
            <form className="flex flex-col gap-2">
              <h2 className="text-black font-semibold text-lg text-center">
                Данные профиля
              </h2>
              <Field
                icon={<UserIcon />}
                placeholder="Имя_пользователя"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
              <Field
                icon={<PhoneIcon />}
                placeholder="000 000 00-00"
                value={phone}
                onChange={(e) => setPhone(e.target.value)}
                startContent="+7"
              />
              <Field
                icon={<EmailIcon />}
                placeholder="example@kubmarket.ru"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
              <div className="mt-4">
                <Button color="dark">Сохранить</Button>
              </div>
            </form>
          </div>
          <div className="bg-white rounded-xl p-6">
            <form className="flex flex-col gap-2">
              <h2 className="text-black font-semibold text-lg text-center">
                Изменить пароль
              </h2>
              <Field
                icon={<PasswordIcon className="text-dark-accent" />}
                placeholder="Старый пароль"
                value={oldPassword}
                onChange={(e) => setOldPassword(e.target.value)}
              />
              <Field
                icon={<PasswordIcon />}
                placeholder="Новый пароль"
                value={newPassword}
                onChange={(e) => setNewPassword(e.target.value)}
              />
              <Field
                icon={<RepeatPasswordIcon />}
                placeholder="Повторите пароль"
                value={repeatedNewPassword}
                onChange={(e) => setRepeatedNewPassword(e.target.value)}
              />
              <div className="mt-4">
                <Button color="dark">Обновить пароль</Button>
              </div>
            </form>
          </div>
        </div>
        <div className="col-span-1 flex flex-col gap-6">
          <div className="bg-white rounded-xl p-6 flex flex-col items-center justify-center gap-4">
            <h2 className="text-black font-semibold text-lg text-center">
              Сумма выкупа
            </h2>
            <span className="text-4xl font-semibold">
              ₽ <span className="text-dark-accent">47 264.34</span>
            </span>
          </div>
          <div className="bg-white rounded-xl p-6 flex flex-col items-center justify-center gap-4">
            <h2 className="text-black font-semibold text-lg text-center">
              Процент выкупа
            </h2>
            <span className="text-4xl font-semibold">
              <span className="text-dark-accent">68.12</span>%
            </span>
          </div>
          <div className="bg-white rounded-xl p-6 flex flex-col items-center justify-center gap-4">
            <h2 className="text-black font-semibold text-lg text-center">
              Ваша скидка
            </h2>
            <span className="text-4xl font-semibold">
              <span className="text-dark-accent">5.88</span>%
            </span>
          </div>
          <div className="bg-white rounded-xl p-6 flex flex-col items-center justify-center gap-4">
            <h2 className="text-black font-semibold text-lg text-center">
              Платежное средство
            </h2>
            <form className="flex flex-col gap-2">
              <Field
                icon={<BankCardIcon />}
                placeholder="Старый пароль"
                value={cardNumber}
                onChange={(e) => setCardNumber(e.target.value)}
              />
              <div className="grid grid-cols-2 gap-2">
                <Field
                  icon={<CalendarIcon />}
                  placeholder="Новый пароль"
                  value={cardDate}
                  onChange={(e) => setCardDate(e.target.value)}
                />
                <Field
                  startContent="CVC"
                  placeholder="Повторите пароль"
                  value={CVC}
                  onChange={(e) => setCVC(e.target.value)}
                />
              </div>
              <div className="mt-4">
                <Button color="dark">Обновить пароль</Button>
              </div>
            </form>
          </div>
        </div>
        <div className="col-span-2">
          <DeliveryList
            codeForReceive="123-123"
            items={[
              {
                title: "Помидоры",
                imgPath: "./pomodoro.png",
                price: 250,
                unit: "кг",
                count: 4,
                dateOrder: "01.01.2024",
                dateDelivery: "01.03.2025",
                status: "в пути",
              },
              {
                title: "Огурцы",
                imgPath: "./cucumbers.png",
                price: 250,
                unit: "кг",
                count: 4,
                dateOrder: "01.01.2024",
                dateDelivery: "01.01.2022",
                status: "в пути",
              },
            ]}
          />
        </div>
      </div>
    </div>
  );
};

export default AuthPage;
