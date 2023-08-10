package guestbook.web

import guestbook.domain.Guestbook
import org.reduxkotlin.threadsafe.createTypedThreadSafeStore

data class HomeState(
    val pageSize: Int = 10,
    val offset: Long = 0,
    val guestbooks: List<Guestbook> = emptyList(),
) {
    companion object {
        fun createStore() = createTypedThreadSafeStore(::reduce, HomeState())

        private fun createInitialState(): HomeState {
            TODO()
        }

        private fun reduce(state: HomeState, action: HomeAction): HomeState = when (action) {
            is HomeAction.NextPage -> state.copy(offset = state.offset + state.pageSize)
            is HomeAction.PreviousPage -> state.copy(offset = state.offset - state.pageSize)
            is HomeAction.GoToPage -> state.copy(offset = action.offset)
            is HomeAction.SetPageSize -> state.copy(pageSize = action.pageSize)
            is HomeAction.AddGuestbook -> state.copy(guestbooks = state.guestbooks + action.guestbook)
        }
    }
}

sealed interface HomeAction {

    // pagination
    data object NextPage : HomeAction
    data object PreviousPage : HomeAction
    data class GoToPage(val offset: Long) : HomeAction
    data class SetPageSize(val pageSize: Int) : HomeAction

    data class AddGuestbook(val guestbook: Guestbook) : HomeAction
}
