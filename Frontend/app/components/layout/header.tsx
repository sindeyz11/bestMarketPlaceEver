"use client";

import { Field } from "@/components/ui/field";
import authStore from "@/store/auth";
import cartStore from "@/store/cart";
import { observer } from "mobx-react-lite";
import Image from "next/image";
import Link from "next/link";
import { AdminPanelIcon } from "../icons/admin-panel-icon";
import { CartIcon } from "../icons/cart-icon";
import { LogoutIcon } from "../icons/logout-icon";
import { ManagerPanelIcon } from "../icons/manager-panel-icon";
import { SearchIcon } from "../icons/search-icon";
import { UserIcon } from "../icons/user-icon";
import { Button } from "../ui/button";
import authorizedUserStore from "@/store/authorizedUser";
import toast from "react-hot-toast";
import { useRouter } from "next/navigation";
import { useAuth } from "@/hooks/useAuth";
import { loadToken } from "@/utils/load-token";

export const Header = observer(() => {
  const user = useAuth();
  const userRole = loadToken()?.role;
  const router = useRouter();
  const handleLogout = () => {
    toast.success("Вы успешно вышли из аккаунта");
    router.push("/auth");
    authorizedUserStore.logout();
  };
  return (
    <header className="flex h-20 w-full items-center justify-between gap-24 px-20">
      <div className="ml-2 flex w-1/2 items-center gap-8">
        <Link href="/">
          <Image
            src="/logos/Main_logo.png"
            width={140}
            height={80}
            objectFit="contain"
            alt="Скачайте приложение KubMarket для Android"
          />
        </Link>
        {user ? (
          <Field icon={<SearchIcon />} placeholder="Поиск товаров..." />
        ) : (
          <Field
            disabled
            placeholder="Войдите или зарегистрируйтесь, чтобы продолжить"
          />
        )}
      </div>
      <div className="flex flex-wrap items-center justify-between">
        <Link href="tel:8800666311" className="mr-20 hidden 2xl:block">
          <div className="flex flex-col items-end">
            <b className="text-base font-extrabold leading-none">
              8 800 666 13-11
            </b>
            <span className="text-end text-xs font-medium leading-none text-secondary-text">
              Поддержка 24/7
            </span>
          </div>
        </Link>
        <div className="flex flex-row-reverse items-center justify-end gap-4">
          {user.data && (
            <Button
              variant="icon"
              icon={<LogoutIcon className="h-6 w-6" />}
              onClick={() => handleLogout()}
            />
          )}
          <Link
            href={user.data ? "/cart" : "#"}
            className="flex items-center gap-4 rounded-lg p-2 transition-colors hover:bg-transparent/5"
          >
            <div className="relative">
              {cartStore.getTotalItems() !== 0 && (
                <div className="absolute bottom-5 left-4 flex h-3 w-3 items-center justify-center rounded bg-dark-accent px-3 py-2 text-xs font-bold text-white">
                  {cartStore.getTotalItems()}
                </div>
              )}
              <CartIcon className="h-8 w-8 text-icon" />
            </div>
            <div className="flex flex-col items-start">
              <span className="text-end text-xs font-medium leading-none text-secondary-text">
                Ваша корзина
              </span>
              <b className="text-base font-extrabold leading-none">
                {user.data ? (
                  <p>
                    ₽
                    {Intl.NumberFormat("ru", {
                      style: "decimal",
                      minimumFractionDigits: 2,
                      maximumFractionDigits: 2,
                    }).format(cartStore.getTotalPrice())}
                  </p>
                ) : (
                  "недоступна"
                )}
              </b>
            </div>
          </Link>
          <Link href={user.data ? "/profile" : "/auth"}>
            <Button
              variant="icon"
              icon={<UserIcon className="h-6 w-6 text-icon" />}
            />
          </Link>
          {userRole === "ADMIN" && (
            <Link href="/admin-panel">
              <Button
                variant="icon"
                icon={<AdminPanelIcon className="h-6 w-6 text-icon" />}
              />
            </Link>
          )}
          {userRole === "MANAGER" && (
            <Link href="/manager-panel">
              <Button
                variant="icon"
                icon={<ManagerPanelIcon className="h-6 w-6 text-icon" />}
              />
            </Link>
          )}
        </div>
      </div>
    </header>
  );
});
