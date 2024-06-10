import { IUser } from "@/types";
import { formatNumber } from "@/utils";

export const UserItem = ({
  code,
  name,
  role,
  discount,
  redemptionSum,
}: Omit<IUser, "redemptionPercentage">) => {
  return (
    <div className="p-4 rounded-lg bg-secondary-bg flex items-center justify-between">
      <div className="flex flex-col gap-1">
        <h3 className="font-semibold text-lg">{name}</h3>
        <div className="flex flex-col leading-none">
          <span>{code}</span>
          <span>{role}</span>
        </div>
      </div>
      <div className="flex flex-col items-end justify-between">
        <span className="text-xl font-medium">{discount}%</span>
        <span className="text-xl font-medium">
          ₽{formatNumber(redemptionSum)}
        </span>
      </div>
    </div>
  );
};
