import Image from "next/image";
import { Field } from "@/components/ui/field";
import Link from "next/link";
import { SearchIcon } from "../icons/search-icon";
import { CartIcon } from "../icons/cart-icon";
import { Button } from "../ui/button";
import { UserIcon } from "../icons/user-icon";

export const Header = () => {
  const isAuth = false; // состояние для проверки пользователя на авторизованность
  return (
    <header className="h-20 px-20 w-full flex items-center justify-between gap-24">
      <div className="w-1/2 flex items-center gap-8 ml-2">
        <Link href="/">
          <Image
            src="/logos/Main_logo.png"
            width={140}
            height={80}
            objectFit="contain"
            alt="Скачайте приложение KubMarket для Android"
          />
        </Link>
        {isAuth ? (
          <Field placeholder="Поиск товаров..." icon={<SearchIcon />} />
        ) : (
          <Field
            placeholder="Войдите или зарегистрируйтесь, чтобы продолжить"
            disabled
          />
        )}
      </div>
      <div className="w-1/2 flex items-center justify-between">
        <Link href="tel:8800666311">
          <div className="flex flex-col items-end">
            <b className="text-base leading-none font-extrabold">
              8 800 666 13-11
            </b>
            <span className="text-end text-secondary-text leading-none text-xs font-medium">
              Поддержка 24/7
            </span>
          </div>
        </Link>
        <div className="flex flex-row-reverse items-center gap-4">
          <Link
            href="/cart"
            className="flex items-center gap-2 p-2 hover:bg-transparent/5 transition-colors rounded-lg"
          >
            <CartIcon className="h-8 w-8 text-icon" />
            <div className="flex flex-col items-start">
              <span className="text-end text-secondary-text leading-none text-xs font-medium">
                Ваша корзина
              </span>
              <b className="text-base leading-none font-extrabold">₽20000.00</b>
            </div>
          </Link>
          <Link href="/profile">
            <Button
              variant="icon"
              icon={<UserIcon className="h-6 w-6 text-icon" />}
            />
          </Link>
          {/* далее зависит от роли пользователя */}
        </div>
      </div>
    </header>
  );
};
