import { loadToken } from '@/utils/load-token'
import { NextResponse } from 'next/server'
import type { NextRequest } from 'next/server'

export function middleware(request: NextRequest) {
    const token = loadToken()
    if (!token) return NextResponse.redirect(new URL('/auth', request.url))
    return NextResponse.next()
}

export const config = {
    matcher: '/:path*',
};