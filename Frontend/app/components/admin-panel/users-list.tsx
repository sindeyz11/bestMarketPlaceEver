"use client";
import authStore from "@/store/auth";
import { UserItem } from "./user-item";
import UserService from "@/app/api/user-service";
import { useEffect, useState } from "react";
import { useQuery } from "@tanstack/react-query";
import { Loading } from "../layout/loading";

export const UsersList = () => {
  const { data, isLoading, isError, error } = useQuery({
    queryKey: ["usersList"],
    queryFn: async () => {
      const response = await UserService.getAllUsers();
      return response.data;
    },
  });

  const allUsers = data;

  if (isLoading) {
    return <Loading />;
  }

  if (isError) {
    return (
      <div className="flex h-screen w-full items-center justify-center rounded-xl bg-white">
        <p>Произошла ошибка при получении данных: {error.message}</p>
      </div>
    );
  }

  return (
    <div className="rounded-xl bg-white p-6 shadow-lg">
      <h2 className="text-lg font-semibold text-black">Пользователи</h2>
      {allUsers?.length ? (
        <div className="mt-2 flex h-[calc(100dvh-235px)] flex-col gap-3 overflow-auto">
          {allUsers?.map((user, index) => (
            <UserItem
              code={index}
              role={user.role.toLowerCase()}
              name={user.username}
              discount={user.user_discount || 0}
              redemptionSum={user.amount_spent}
              key={index}
            />
          ))}
        </div>
      ) : (
        <div className="flex h-[300px] flex-col items-center justify-center">
          <p className="text-secondary-text/40">Пользователи отсутсвуют</p>
        </div>
      )}
    </div>
  );
};
