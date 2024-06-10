import authStore from "@/store/auth";
import { UserItem } from "./user-item";

export const UsersList = () => {
  return (
    <div className="bg-white shadow-lg rounded-xl p-6">
      <h2 className="text-black font-semibold text-lg">Пользователи</h2>
      {authStore.users.length ? (
        <div className="flex flex-col gap-3">
          {authStore.users.map((user) => (
            <UserItem
              code={user.code}
              role={user.role}
              name={user.name}
              discount={user.discount}
              redemptionSum={user.redemptionSum}
              key={user.code}
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
