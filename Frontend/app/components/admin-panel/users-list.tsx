"use client";
import authStore from "@/store/auth";
import { UserItem } from "./user-item";
import UserService from "@/app/api/user-service";
import { useEffect, useState } from "react";

export const UsersList = () => {
  const [allUsers, setAllUsers] = useState<null | any[]>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await UserService.getAllUsers();
        if (response.status === 200) {
          setAllUsers(response.data);
        } else {
          console.error("Ошибка при получении данных:", response.statusText);
        }
      } catch (error) {
        console.error("Ошибка при получении данных:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="bg-white shadow-lg rounded-xl p-6">
      <h2 className="text-black font-semibold text-lg">Пользователи</h2>
      {allUsers?.length ? (
        <div className="flex flex-col gap-3 mt-2 h-[calc(100dvh-235px)] overflow-auto">
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
        <div className="h-[300px] flex flex-col items-center justify-center">
          <p className="text-secondary-text/40">Пользователи отсутсвуют</p>
        </div>
      )}
    </div>
  );
};
