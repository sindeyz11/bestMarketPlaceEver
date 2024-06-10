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

export const Header = observer(() => {
	const role = authStore.role;
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
				{role !== "not-authorized" ? (
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
					{role !== "not-authorized" && (
						<Button variant="icon" icon={<LogoutIcon className="h-6 w-6" />} />
					)}
					<Link
						href="/cart"
						className="flex items-center gap-4 p-2 hover:bg-transparent/5 transition-colors rounded-lg"
					>
						<div className="relative">
							{cartStore.getTotalItems() !== 0 && (
								<div className="absolute bottom-5 left-4 w-3 h-3 flex items-center justify-center bg-dark-accent px-3 py-2 text-xs text-white font-bold rounded">
									{cartStore.getTotalItems()}
								</div>
							)}
							<CartIcon className="h-8 w-8 text-icon" />
						</div>
						<div className="flex flex-col items-start">
							<span className="text-end text-secondary-text leading-none text-xs font-medium">
								Ваша корзина
							</span>
							<b className="text-base leading-none font-extrabold">
								₽
								{Intl.NumberFormat("ru", {
									style: "decimal",
									minimumFractionDigits: 2,
									maximumFractionDigits: 2,
								}).format(cartStore.getTotalPrice())}
							</b>
						</div>
					</Link>
					<Link href={role !== "not-authorized" ? "/profile" : "/auth"}>
						<Button
							variant="icon"
							icon={<UserIcon className="h-6 w-6 text-icon" />}
						/>
					</Link>
					{role === "admin" && (
						<Link href="/admin-panel">
							<Button
								variant="icon"
								icon={<AdminPanelIcon className="h-6 w-6 text-icon" />}
							/>
						</Link>
					)}
					{role === "manager" && (
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
