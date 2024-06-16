"use client";

import { DeliveryList } from "@/components/delivery/delivery-panel";
import { ChangePasswordPanel } from "@/components/profile/user/change-password-panel";
import { PaymentData } from "@/components/profile/user/payment-data";
import { StatisticsPanel } from "@/components/profile/user/statistics-panel";
import { UserData } from "@/components/profile/user/user-data";
import deliveryStore from "@/store/delivery";
import { useState } from "react";
import authorizedUserStore from "@/store/authorizedUser";
import { map } from "yaml/dist/schema/common/map";

const ProfilePage = () => {
  {
    /*  FIXME: здесь данные берутся с backend   */
  }
  const username = authorizedUserStore.user?.username;
  const phone = authorizedUserStore.user?.phone;
  const email = authorizedUserStore.user?.email;
  const cardNumber = authorizedUserStore.user?.cardNumber;
  const cardDate = authorizedUserStore.user?.validity;
  const cardCVC = authorizedUserStore.user?.CVC;
  const amountSpent = authorizedUserStore.user?.amountSpent;
  const redemptionPercent = authorizedUserStore.user?.redemptionPercent;
  const userDiscount = authorizedUserStore.user?.userDiscount;
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
            usernameData={username}
            phoneData={phone?.replace("+7", "")}
            emailData={email}
          />
          <ChangePasswordPanel />
        </div>
        <div className="col-span-1 flex flex-col gap-6">
          {/*  FIXME: здесь данные берутся с backend   */}
          <StatisticsPanel
            title="Сумма выкупа"
            stats={amountSpent || 0}
            unit="₽"
            unitPosition="left"
          />
          <StatisticsPanel
            title="Процент выкупа"
            stats={redemptionPercent || 0}
            unit="%"
          />
          <StatisticsPanel
            title="Ваша скидка"
            stats={userDiscount || 0}
            unit="%"
          />
          <PaymentData
            cardNumberData={cardNumber || ""}
            cardDateData={cardDate || ""}
            CVCData={cardCVC?.toString() || ""}
          />
        </div>
        <div className="col-span-2">
          {deliveryStore.deliveryItems.length ? (
            <DeliveryList
              codeForReceive="123-123"
              items={deliveryStore.deliveryItems}
            />
          ) : (
            <p>Вам ничего не должны доставлять</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default ProfilePage;
