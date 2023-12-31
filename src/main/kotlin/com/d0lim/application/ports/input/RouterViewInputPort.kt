package com.d0lim.application.ports.input

import com.d0lim.application.ports.output.RouterViewOutputPort
import com.d0lim.application.usecases.RouterViewUseCase
import com.d0lim.domain.entity.Router
import com.d0lim.domain.service.RouterSearch

class RouterViewInputPort(
    private val routerListOutputPort: RouterViewOutputPort,
) : RouterViewUseCase {
    override fun getRouters(filter: (Router) -> Boolean): List<Router> {
        val routers = routerListOutputPort.fetchRouters()
        return RouterSearch.retrieveRouters(routers, filter)
    }
}
