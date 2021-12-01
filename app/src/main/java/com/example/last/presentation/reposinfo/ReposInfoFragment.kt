package com.example.last.presentation.reposinfo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.last.data.user.GithubRepository
import com.example.last.data.user.GithubUserRepository
import com.example.last.databinding.FragmentReposInfoBinding
import com.example.last.presentation.abs.AbsFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class ReposInfoFragment : AbsFragment(), ReposInfoView {

    companion object {
        private const val USER_LOGIN = "user_login"
        private const val REPOS_NAME = "repos_name"

        fun newInstance(userLogin: String, reposName: String) =
            ReposInfoFragment().apply {
                arguments = bundleOf(USER_LOGIN to userLogin, REPOS_NAME to reposName)
            }
    }

    private var _binding: FragmentReposInfoBinding? = null
    private val viewBinding: FragmentReposInfoBinding
        get() {
            return _binding!!
        }

    @Inject
    lateinit var githubUserRepository: GithubUserRepository

    private val presenter: ReposInfoPresenter by moxyPresenter {
        ReposInfoPresenter(
            userLogin, reposName, githubUserRepository
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReposInfoBinding.inflate(inflater)
        return viewBinding.root
    }

    private val userLogin: String by lazy {
        arguments?.getString(USER_LOGIN).orEmpty()
    }

    private val reposName: String by lazy {
        arguments?.getString(REPOS_NAME).orEmpty()
    }

    @SuppressLint("SetTextI18n")
    override fun showInfo(repository: GithubRepository) {
        viewBinding.tvReposInfo.text =
            "Name: ${repository.name}\n" +
                    "Description: ${repository.description}\n" +
                    "Forks count: ${repository.forksCount}\n" +
                    "Size: ${repository.size}"
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
    }

    override fun showEmpty() {
        viewBinding.tvReposInfo.text = "Not found!"
    }
}