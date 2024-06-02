"use client";

import { DeliveryList } from "@/components/delivery/delivery-panel";
import { ChangePasswordPanel } from "@/components/profile/user/change-password-panel";
import { PaymentData } from "@/components/profile/user/payment-data";
import { StatisticsPanel } from "@/components/profile/user/statistics-panel";
import { UserData } from "@/components/profile/user/user-data";
import { useState } from "react";

const ProfilePage = () => {
  {/*  FIXME: здесь данные берутся с backend   */}
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
          {/*  FIXME: здесь данные берутся с backend   */}
          <UserData
            usernameData="khudobin_v"
            phoneData="9885582402"
            emailData="khudobin_v@icloud.com"
          />
          <ChangePasswordPanel />
        </div>
        <div className="col-span-1 flex flex-col gap-6">
          {/*  FIXME: здесь данные берутся с backend   */}
          <StatisticsPanel
            title="Сумма выкупа"
            stats={47624.34}
            unit="₽"
            unitPosition="left"
          />
          <StatisticsPanel title="Процент выкупа" stats={68.12} unit="%" />
          <StatisticsPanel title="Ваша скидка" stats={5.88} unit="%" />
          <PaymentData
            cardNumberData="1234 5678 9012 3456"
            cardDateData="05/24"
            CVCData="383"
          />
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

export default ProfilePage;
