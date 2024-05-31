import { PasswordIcon } from '@/components/icons/password-icon'
import { RepeatPasswordIcon } from '@/components/icons/repeat-password-icon'
import { Button } from '@/components/ui/button'
import { Field } from '@/components/ui/field'
import { useState } from 'react'

export const ChangePasswordPanel = () => {
	const [oldPassword, setOldPassword] = useState<string>('')
	const [newPassword, setNewPassword] = useState<string>('')
	const [repeatedNewPassword, setRepeatedNewPassword] = useState<string>('')
	return (
		<div className='bg-white rounded-xl shadow-lg p-6'>
			<form className='flex flex-col gap-2'>
				<h2 className='text-black font-semibold text-lg text-center'>
					Изменить пароль
				</h2>
				<Field
					icon={<PasswordIcon className='text-dark-accent' />}
					placeholder='Старый пароль'
					value={oldPassword}
					onChange={e => setOldPassword(e.target.value)}
				/>
				<Field
					icon={<PasswordIcon />}
					placeholder='Новый пароль'
					value={newPassword}
					onChange={e => setNewPassword(e.target.value)}
				/>
				<Field
					icon={<RepeatPasswordIcon />}
					placeholder='Повторите пароль'
					value={repeatedNewPassword}
					onChange={e => setRepeatedNewPassword(e.target.value)}
				/>
				<div className='mt-4'>
					<Button color='dark'>Обновить пароль</Button>
				</div>
			</form>
		</div>
	)
}
