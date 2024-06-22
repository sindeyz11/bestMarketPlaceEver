"use client";

import { DeliveryList } from "@/components/delivery/delivery-panel";
import { ChangePasswordPanel } from "@/components/profile/user/change-password-panel";
import { PaymentData } from "@/components/profile/user/payment-data";
import { StatisticsPanel } from "@/components/profile/user/statistics-panel";
import { UserData } from "@/components/profile/user/user-data";
import deliveryStore from "@/store/delivery";
import { useState } from "react";
import authorizedUserStore from "@/store/authorizedUser";
import { red } from "next/dist/lib/picocolors";

const ProfilePage = () => {
  return (
    <div
      style={{ minHeight: "calc(100dvh - 240px)" }}
      className="flex bg-[#F6F6F6] py-10"
    >
      <title>Профиль</title>
      <div className="grid h-full w-full grid-cols-4 gap-6 px-20">
        <div className="col-span-1 flex flex-col gap-6">
          {/*  FIXME: здесь данные берутся с backend   */}
          <UserData />
          <ChangePasswordPanel />
        </div>
        <div className="col-span-1 flex flex-col gap-6">
          {/*  FIXME: здесь данные берутся с backend   */}
          <StatisticsPanel
            title="Сумма выкупа"
            stats={0}
            unit="₽"
            unitPosition="left"
          />
          <StatisticsPanel title="Процент выкупа" stats={0} unit="%" />
          <StatisticsPanel title="Ваша скидка" stats={0} unit="%" />
          <PaymentData cardNumberData={""} cardDateData={""} CVCData={""} />
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
